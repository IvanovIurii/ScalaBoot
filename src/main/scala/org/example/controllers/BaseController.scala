package org.example.controllers

import javax.servlet.http.HttpServletResponse
import org.example.entities.Task
import org.example.enums.Status
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, ResponseBody, RestController}

@RequestMapping(path = Array("/tasks"))
@RestController
class BaseController {
    @GetMapping(path = Array("/"))
    def demo: String = {
        "Welcome!"
    }

    @GetMapping(path = Array("/all"))
    def tasks(rsp: HttpServletResponse): Unit = {
        val response = setResponse(rsp) _

        val todo = Task("Write App in Scala", Status.Created)
        response(todo, 200)
    }

    def setResponse[T](response: HttpServletResponse)(res: T, statusCode: Int): Unit = {
        response.setStatus(statusCode)
        response.getWriter.println(res)
        response.getWriter.flush()
        response.getWriter.close()
    }
}





