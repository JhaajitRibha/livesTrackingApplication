package com.samar.technology.LivesTracker.controller;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.service.LivesDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1/dictionary")
public class LivesDictionaryController {


    @Autowired
    LivesDictionaryService livesDictionaryService;

    @GetMapping("/words")
    public List<LivesDictionary> getAllDictionaries(){
        return livesDictionaryService.getLivesDictionaries();
    }

    @PostMapping("/words")
    public String dictionaryInsertion(@RequestBody LivesDictionary livesDictionary){
        return livesDictionaryService.dictionaryInsertion(livesDictionary);
    }

}


// JAX-RS implementation

//        import com.samar.technology.LivesTracker.model.LivesDictionary;
//        import com.samar.technology.LivesTracker.service.LivesDictionaryService;
//
//        import javax.inject.Inject;
//        import javax.ws.rs.*;
//        import javax.ws.rs.core.MediaType;
//        import javax.ws.rs.core.Response;
//        import java.util.List;
//
//@Path("/apis/v1/dictionary")
//public class LivesDictionaryController {
//
//    @Inject
//    private LivesDictionaryService livesDictionaryService;
//
//    @GET
//    @Path("/words")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAllDictionaries() {
//        List<LivesDictionary> dictionaries = livesDictionaryService.getLivesDictionaries();
//        return Response.ok(dictionaries).build();
//    }
//
//    @POST
//    @Path("/words")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response dictionaryInsertion(LivesDictionary livesDictionary) {
//        String result = livesDictionaryService.dictionaryInsertion(livesDictionary);
//        return Response.ok(result).build();
//    }
//}

