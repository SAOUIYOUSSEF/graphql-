package ma.xproce.inventoryservice.web;

import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import ma.xproce.inventoryservice.repositories.CreatorRepository;
import ma.xproce.inventoryservice.repositories.VideoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class VideoGraphQlController {
    private VideoRepository videoRepo;
    private CreatorRepository creatorRepo;
    VideoGraphQlController(CreatorRepository creatorRepo, VideoRepository videoRepo){
        this.videoRepo = videoRepo;
        this.creatorRepo = creatorRepo;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepo.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepo
                .findById(id)
                .orElseThrow(()
                ->new RuntimeException(String.format("Creator %s not found",id)));
    }
    @MutationMapping
    public Video saveVideo(@Argument Video video){
        return videoRepo.save(video) ;
    }
    @MutationMapping
    public Creator saveCreator(@Argument Creator creator){
        return creatorRepo.save(creator);
    }
}
