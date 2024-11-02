package com.milkiyti.property_management.repository;

import com.milkiyti.property_management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
