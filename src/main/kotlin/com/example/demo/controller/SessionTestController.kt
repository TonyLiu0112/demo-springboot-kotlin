package com.example.demo.controller

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("test/session")
@SessionAttributes(value = "map")
class SessionTestController {

    @GetMapping("put")
    fun put(model: Model) {
        val map = hashMapOf<String, Any>()
        map.put("name", "liuboyu")
        model.addAttribute("map", map)
    }

    @GetMapping("change")
    fun change(@ModelAttribute("map") map: HashMap<String, Any>): Any? {
        val beforeName = map["name"]
        map.put("name", "Tony")
        return "Before: $beforeName, After: ${map["name"]} "
    }

    @GetMapping("show")
    fun show(@ModelAttribute("map") map: HashMap<String, Any>): Any? { // 问号用于申明空值检查
        return map["name"]
    }

}