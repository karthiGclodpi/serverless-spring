package com.demo.service

import org.json.JSONObject
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by karthirockz on 23/03/17.
 */

@RestController
@PropertySource(ignoreResourceNotFound = true, value = "classpath:games.properties")
class GameVersionService {

    @Value('${gameVersion}')
    Integer GAME_VERSION

    @RequestMapping(value = "/games/{gameId}/version", method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<String> get(@PathVariable("gameId") int gameId) {

        JSONObject jsonData = new JSONObject()
        jsonData.put('id', gameId)
        jsonData.put('version', GAME_VERSION)
        return ResponseEntity.ok(new JSONObject().put("jsonData", jsonData).toString())

    }

}
