package com.messager.service.bootstrap;

import com.messager.service.com.messager.service.model.Profile;
import com.messager.service.repositories.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class ProfileBootStrap implements CommandLineRunner {

    private final ProfileRepository profileRepository;

    public ProfileBootStrap(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Profile Data!!!");



        Profile profile1 = new Profile();

        profile1.setFirstName("Philip");
        profile1.setLastName("Jonah");
        profile1.setProfileName("Benito");
        profile1.setCreated(LocalDate.now());

        profileRepository.save(profile1);


        Profile profile2 = new Profile();

        profile2.setFirstName("James");
        profile2.setLastName("Martin");
        profile2.setProfileName("Martino");
        profile2.setCreated(LocalDate.now());

        profileRepository.save(profile2);

        Profile profile3 = new Profile();

        profile3.setFirstName("Alex");
        profile3.setLastName("Bradley");
        profile3.setProfileName("Bradshawn");
        profile3.setCreated(LocalDate.now());

        profileRepository.save(profile3);

        System.out.println("Profile Saved: " + profileRepository.count());

    }
}
