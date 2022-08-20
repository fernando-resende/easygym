package personal.project.easygym.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    public Optional<T> findById(Long id);
    public List<T> findAll();
    public T createOrUpdate(T entity);
    public void delete(Long id);
}
