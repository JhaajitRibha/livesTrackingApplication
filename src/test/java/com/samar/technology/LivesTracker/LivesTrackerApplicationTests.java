package com.samar.technology.LivesTracker;

import com.samar.technology.LivesTracker.ThirdPartyUsingRestTemplate.restTemplateService.RestTemplateService;
import com.samar.technology.LivesTracker.model.Blog;
import com.samar.technology.LivesTracker.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;


@SpringBootTest
class LivesTrackerApplicationTests {

	@Autowired
	private WebClient.Builder webclientBuilder;

	@Autowired
	private RestTemplateService restTemplateService;

	@Test
	void contextLoads() {
	}

	@Test
	void info(){
		System.out.println("testing by Ajit Jha");
	}

	@Test
	void postInfo(){
		System.out.println(restTemplateService.getPostById(1));
	}

	@Test
	void monoDemo(){

		Mono<Object> monoErrorOne =  Mono.error(new ArrayIndexOutOfBoundsException("array index out of bound exception occurred")).log();
		Mono<Object> monoOne = Mono.just("working with mono").log().then(monoErrorOne);
		monoOne.subscribe(data-> System.out.println("data:"+ data));
		Mono<Object> monoErrorTwo =  Mono.error(new ArrayIndexOutOfBoundsException("array index out of bound exceptin occured")).log();
		monoErrorTwo.subscribe(System.out::println);
	}

	@Test
	void blogMonoDemo(){
		byte[] imageData = new byte[]{1,2,3};
		Mono<Blog> monoBlogOne = Mono.just(
				new Blog(101l,"mono","learingMono",
						imageData,
						new User("ajit","ajit@gmail.com"))).log();

		monoBlogOne.subscribe(data->{
			System.out.println(data.getBlogHeading() + "  is given by " + data.getUser().getEmail());
		});
	}
	@Test
	void monoTuple(){
		Mono<User> user1 = Mono.just(new User("samar","samar@gmail.com"));
		Mono<User> user2 = Mono.just(new User("akhilesh","khilesh@gmail.com"));

		Mono<Tuple2<User,User>> zippedUser = Mono.zip(user1,user2);
		zippedUser.subscribe(data->{
			System.out.println(data.getT1().toString());
			System.out.println(data.getT2().toString());
		});

		Mono<Tuple2<User,User>> zippedWithUser = user1.zipWith(user2);
		zippedWithUser.subscribe((data)->{
			System.out.println(data.getT1().toString());
			System.out.println(data.getT2().toString());
		});

        Mono<User> tranformedUserWithMap = user1.map(data->{
			String email = data.getEmail().toUpperCase();
			String username = data.getUsername().toUpperCase();

			return new User(username,email);

		});

		System.out.println("*****************");
		tranformedUserWithMap.subscribe(data-> System.out.println(data));

		System.out.println("*********************");

		Mono<String> infoForFlatMap = Mono.just("This feature will enhance flat map");
		Mono<String[]> flattenInfo = infoForFlatMap.flatMap(f->Mono.just(f.split(" ")));
		flattenInfo.subscribe(data->{
			for(String d: data){
				System.out.print(d + "         ");
			}
		});
		System.out.println();
		System.out.println("flux string *************");
		Flux<String> stringFlux = infoForFlatMap.flatMapMany(f->Flux.just(f.split(" ")));
		stringFlux.subscribe(data->System.out.println(data));


		Mono<String> m1 = Mono.just("ajit");
		Mono<String> m2 = Mono.just("samar");

		System.out.println("concat ****************");

		Flux<String> m1m2 = m1.concatWith(m2);
		m1m2.subscribe(data-> System.out.print(data));

	}

//	@Test
//	void testFetchFakeJson(){
//
//		WebClient webClient = webclientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
//		Flux<Post> fetchedPosts = webClient.get().uri("/posts").retrieve().bodyToFlux(Post.class);
//		fetchedPosts.subscribe(post->{
//			System.out.println(post.toString());
//		});

//	}

}

