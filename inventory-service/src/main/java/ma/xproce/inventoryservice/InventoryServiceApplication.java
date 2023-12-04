package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.entities.Creator;
import ma.xproce.inventoryservice.entities.Video;
import ma.xproce.inventoryservice.repositories.CreatorRepository;
import ma.xproce.inventoryservice.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
		return args -> {
			List<Creator> creators = List.of(
					Creator.builder()
							.name("a")
							.email("a@yahoo.com").build(),
					Creator.builder()
							.name("b")
							.email("b@outlook.com").build(),
					Creator.builder()
							.name("c")
							.email("c@gmail.com").build(),
					Creator.builder()
							.name("d")
							.email("d@gmail.com").build());

			for (Creator cr : creators) {
				creatorRepository.save(cr);
			}

			List<Video> videos = List.of(
					Video.builder()
							.name("video1")
							.url("video1.com")
							.datePublication(new Date())
							.description("video1 description")
							.creator(creators.get(0)).build(),
					Video.builder()
							.name("video2")
							.url("video2.com")
							.datePublication(new Date())
							.description("video2 description")
							.creator(creators.get(1)).build(),
					Video.builder()
							.name("video3")
							.url("video3.com")
							.datePublication(new Date())
							.description("video3 description")
							.creator(creators.get(2)).build(),
					Video.builder()
							.name("video4")
							.url("video4.com")
							.datePublication(new Date())
							.description("video4 description")
							.creator(creators.get(3)).build());

			for (Video video : videos) {
				videoRepository.save(video);
			}
		};
	}
}