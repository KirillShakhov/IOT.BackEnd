package ru.itapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    private static Double wet = 0D;
    private static Double temp = 0D;
    private static Double humidity = 0D;
    private static boolean light = false;

    @GetMapping("/info")
    public String getInfo() {
        return wet + ";" + temp + ";" + humidity;
    }

    @GetMapping("/info/edit")
    public String editInfo(@RequestParam(value = "wet") Double wet,
                           @RequestParam(value = "temp") Double temp,
                           @RequestParam(value = "humidity") Double humidity) {
        MenuController.wet = wet;
        MenuController.temp = temp;
        MenuController.humidity = humidity;
        return "Ok";
    }

    @GetMapping("/light")
    public String getLight() {
        return String.valueOf(MenuController.light);
    }

    @GetMapping("/light/edit")
    public String setLight(@RequestParam(value = "on") boolean on) {
        MenuController.light = on;
        return "Ok";
    }
}