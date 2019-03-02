package com.messager.service.controllers;

import com.messager.service.com.messager.service.model.Profile;
import com.messager.service.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ProfileController.BASEURL)
public class ProfileController {

    private final ProfileService profileService;

    public static final String BASEURL = "api/v1/profiles";

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Profile> getAllProfiles() {

        return profileService.findAllProfiles();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Profile findProfileByName(@PathVariable Long id) {
        return profileService.findProfileById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Profile saveProfile(@RequestBody Profile profile) {
        return profileService.saveProfile(profile);
    }


    @PutMapping("/{id}")
    public void updateMessage(@RequestBody Profile profile, @PathVariable Long id) {

        profileService.updateProfile(profile, id);
    }

    @DeleteMapping("{id}")
    public void deleteMessage(@PathVariable Long id) {
        profileService.deleteprofile(id);
    }


}


