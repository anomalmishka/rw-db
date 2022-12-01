package org.example.controller.serviceControllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserLoginDTO;
import org.example.dto.models.L2.UserProfileDTOL2;
import org.example.dto.page.UserProfilePage;
import org.example.mapper.page.UserProfileMapperPage;
import org.example.mapper.userLogin.UserLoginMapper;
import org.example.service.models.registrationUserLogin.RegistrationUserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class RegistrationController {
    private final RegistrationUserLoginService registrationUserLoginService;
    private final UserProfileMapperPage userProfileMapperPage;
    private final UserLoginMapper userLoginMapper;

    @GetMapping("/registration")
    public String registration() {
        return "pages/registration/registration";
    }

    @PostMapping("/registration/create")
    public String registration(Model model,
                               @ModelAttribute UserProfileDTOL2 userProfileDTOL2,
                               @ModelAttribute UserLoginDTO userLoginDTO
    ) {
        UserProfilePage userProfilePage = userProfileMapperPage.toPage(registrationUserLoginService.create(
                userProfileDTOL2, userLoginMapper.toModel(userLoginDTO)
        ));
        model.addAttribute("userProfilePage", userProfilePage);
        model.addAttribute("userDTO", userLoginDTO);
        String redirectUrl = "http://localhost:8001/web-app/login";
        return "redirect:" + redirectUrl;
    }
}
