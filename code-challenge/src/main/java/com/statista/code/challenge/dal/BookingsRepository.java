package com.statista.code.challenge.dal;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingsRepository<T, ID> {


//    @Override
    <S extends T> S save(S entity);
//
//    @Override
//    public <S extends Booking> List<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
     Optional<T> findById(ID aLong);
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
    public List<T> findAll();
//
//    @Override
//    public List<Booking> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(Booking entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Booking> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
}
