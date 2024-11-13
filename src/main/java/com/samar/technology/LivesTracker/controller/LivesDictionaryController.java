package com.samar.technology.LivesTracker.controller;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.service.LivesDictionaryService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.StringWriter;
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

    @GetMapping("/words/xmlString/{wordId}")
    public String getUserXmlString(@PathVariable("wordId") Long id){
        LivesDictionary fetchedDict = livesDictionaryService.getWordMeaningXml(id);
        return convertToXmlString(fetchedDict);
    }
    private String convertToXmlString(LivesDictionary livesDictionary){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(LivesDictionary.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(livesDictionary, stringWriter);

            return stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "Error converting to XML";
        }
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

