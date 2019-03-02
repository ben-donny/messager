package com.messager.service.repositories;

import com.messager.service.com.messager.service.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
