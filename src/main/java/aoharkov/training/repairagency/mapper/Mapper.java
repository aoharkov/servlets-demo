package aoharkov.training.repairagency.mapper;

public interface Mapper<E, D> {

    E mapDomainToEntity(D item);

    D mapEntityToDomain(E entity);
}
