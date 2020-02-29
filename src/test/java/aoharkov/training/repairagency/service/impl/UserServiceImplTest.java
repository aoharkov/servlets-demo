package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.exception.IncorrectPasswordException;
import aoharkov.training.repairagency.service.exception.validation.InvalidEmailException;
import aoharkov.training.repairagency.service.validator.Validator;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String ENCODED_PASSWORD = "$2a$10$0zVxYquinNxduTpbd7iw.OIm7VysEarEuBs0RVBXH4B2s5ktggkvy";
    private static final String PASSWORD = "admin@gmail.com";
    private static final String INCORRECT_PASSWORD = "artem@gmail.com";
    private static final String ENCODED_INCORRECT_PASSWORD =
            "$2a$10$Cke4fwQkrg/vZuTaESojHeaSTEUkaOCceixZY6MzVIbqDkypdba.G";
    private static final String EMAIL = "admin@gmail.com";
    private static final String INVALID_EMAIL = "admin#gmail.com";
    private static final String CORRECT_EMAIL_NOT_IN_DB = "admin@mail.ru";
    private static final UserEntity USER_ENTITY = initUserEntity();
    private static final User USER = initUser();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private Validator<User> userValidator;
    @Mock
    private Encoder passwordEncoder;
    @Mock
    private UserDao userDao;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private static UserEntity initUserEntity() {
        return UserEntity.builder()
                .withId(1)
                .withPassword(ENCODED_PASSWORD)
                .withEmail(EMAIL)
                .build();
    }

    private static User initUser() {
        return User.builder()
                .withId(1)
                .withPassword(ENCODED_PASSWORD)
                .withEmail(EMAIL)
                .build();
    }

    @After
    public void resetMocks() {
        Mockito.reset(userValidator, passwordEncoder, userDao, userMapper);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        doNothing().when(userValidator).validateEmail(eq(EMAIL));
        when(userDao.findByEmail(eq(EMAIL))).thenReturn(Optional.of(USER_ENTITY));
        when(passwordEncoder.check(eq(PASSWORD), eq(ENCODED_PASSWORD))).thenReturn(true);
        when(userMapper.mapEntityToDomain(eq(USER_ENTITY))).thenReturn(USER);

        final User user = userService.login(EMAIL, PASSWORD);
        assertEquals(USER, user);

        verify(userValidator).validateEmail(eq(EMAIL));
        verify(userDao).findByEmail(eq(EMAIL));
        verify(passwordEncoder).check(eq(PASSWORD), eq(ENCODED_PASSWORD));
        verify(userMapper).mapEntityToDomain(eq(USER_ENTITY));
    }

    @Test
    public void userShouldNotLoginAsEmailIsNotValid() {
        doThrow(InvalidEmailException.class).when(userValidator).validateEmail(INVALID_EMAIL);

        exception.expect(InvalidEmailException.class);
        userService.login(INVALID_EMAIL, PASSWORD);

        verify(userValidator).validateEmail(eq(INVALID_EMAIL));
        verifyZeroInteractions(userDao);
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userMapper);
    }

    @Test
    public void userShouldNotLoginAsEmailNotFoundInDB() {
        doNothing().when(userValidator).validateEmail(eq(CORRECT_EMAIL_NOT_IN_DB));
        doThrow(EntityNotFoundException.class).when(userDao).findByEmail(eq(CORRECT_EMAIL_NOT_IN_DB));

        exception.expect(EntityNotFoundException.class);
        userService.login(CORRECT_EMAIL_NOT_IN_DB, PASSWORD);

        verify(userValidator).validateEmail(eq(CORRECT_EMAIL_NOT_IN_DB));
        verify(userDao).findByEmail(eq(CORRECT_EMAIL_NOT_IN_DB));
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userMapper);
    }

    @Test
    public void userShouldNotLoginAsPasswordIsIncorrect() {
        doNothing().when(userValidator).validateEmail(eq(EMAIL));
        when(userDao.findByEmail(eq(EMAIL))).thenReturn(Optional.of(USER_ENTITY));
        when(passwordEncoder.encode(eq(INCORRECT_PASSWORD))).thenReturn(ENCODED_INCORRECT_PASSWORD);

        exception.expect(IncorrectPasswordException.class);
        userService.login(EMAIL, INCORRECT_PASSWORD);

        verify(userValidator).validateEmail(eq(EMAIL));
        verify(userDao).findByEmail(eq(EMAIL));
        verify(passwordEncoder).encode(INCORRECT_PASSWORD);
        verifyZeroInteractions(userMapper);
    }

    @Test
    public void userShouldRegisterSuccessfully() {
        doNothing().when(userValidator).validate(any(User.class));
        when(userDao.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userMapper.mapDomainToEntity(eq(USER))).thenReturn(USER_ENTITY);
        doNothing().when(userDao).save(USER_ENTITY);

        userService.register(USER);

        verify(userValidator).validate(any(User.class));
        verify(userDao).findByEmail(anyString());
        verify(userMapper).mapDomainToEntity(USER);
        verify(userDao).save(USER_ENTITY);
    }

    @Test
    public void userShouldNotRegisterAsEmailIsInvalid() {
        doThrow(InvalidEmailException.class).when(userValidator).validate(any(User.class));

        exception.expect(InvalidEmailException.class);
        userService.register(USER);

        verify(userValidator).validate(any(User.class));
        verifyZeroInteractions(userDao);
        verifyZeroInteractions(userMapper);
        verifyZeroInteractions(userDao);
    }

    @Test
    public void userShouldNotRegisterAsEmailIsAlreadyInDB() {
        doNothing().when(userValidator).validate(any(User.class));
        doThrow(EntityAlreadyExistException.class).when(userDao).findByEmail(EMAIL);

        exception.expect(EntityAlreadyExistException.class);
        userService.register(USER);

        verify(userValidator).validate(any(User.class));
        verify(userDao).findByEmail(anyString());
        verifyZeroInteractions(userMapper);
        verifyZeroInteractions(userDao);
    }
}