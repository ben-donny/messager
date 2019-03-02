package com.messager.service.services;

import com.messager.service.com.messager.service.model.Profile;
import com.messager.service.exceptions.NotFoundException;
import com.messager.service.repositories.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProfileServiceImp implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImp(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findProfileById(Long id) {
       log.debug("introducing exception handling");

       Optional<Profile> profileOptional =  profileRepository.findById(id);
       if (!profileOptional.isPresent()){
           throw new NotFoundException("Profile Not Found. For ID value: " + id.toString());
       }
       //return profileRepository.findById(id).orElse(null);
        return profileOptional.get();
    }

    @Override
    public List<Profile> findAllProfiles() {
        List<Profile> profiles = new ArrayList<>();
        profileRepository.findAll().forEach(profiles::add);
        return  profiles;
    }

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void updateProfile(Profile profile, Long id) {
        profile.setId(id);
        profileRepository.save(profile);
    }

    @Override
    public void deleteprofile(Long id) {
        profileRepository.deleteById(id);
    }
}
