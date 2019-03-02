package com.messager.service.services;

import com.messager.service.com.messager.service.model.Profile;

import java.util.List;

public interface ProfileService {

    Profile findProfileById(Long id);

    List<Profile> findAllProfiles();

    Profile saveProfile(Profile profile);

    void updateProfile(Profile profile, Long id);

    void deleteprofile(Long id);
}
