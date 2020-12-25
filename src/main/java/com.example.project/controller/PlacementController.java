package com.example.project.controller;


import com.example.project.bean.Placement;
import com.example.project.bean.PlacementFilter;
import com.example.project.service.PlacementService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Path("placement")
public class PlacementController {

    PlacementService placementService = new PlacementService();
    //PlacementFilterService placementFilterService = new PlacementFilterService();
    @POST

    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createOffer(@FormDataParam("organisation") String organisation,
                                @FormDataParam("profile") String profile,
                                @FormDataParam("description") String description,
                                @FormDataParam("intake") String intake,
                                @FormDataParam("minimum_grade") String minimum_grade,
                                @FormDataParam("specialisation") String specialisation,
                                @FormDataParam("domain") String domain
                                ) throws URISyntaxException {

        System.out.println(organisation);
        String[] array1 = specialisation.split(" ");
        String[] array2 = domain.split(" ");
        int len1 = array1.length;
        int len2 = array2.length;
        List<PlacementFilter> placement_filter = new ArrayList<>();

        for (int i = 0; i < len1; i++) {
            for (int l = 0; l < len2; l++) {
                placement_filter.add(new PlacementFilter(array1[i], array2[l]));
            }
        }

        Placement placement =  new Placement(organisation, profile, description, intake, minimum_grade, placement_filter);
        if(placementService.createOffer(placement)){
            return Response.ok().build();
        }
        return Response.status(203).build();

    }
}

