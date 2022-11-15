package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

/**
 * Learn how to merge flux.
 *
 * @author Sebastien Deleuze
 */
public class Part05Merge {

//========================================================================================

	// TODO Merge flux1 and flux2 values with interleave
	Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
		System.out.println("flux1 = " + flux1.toStream().collect(Collectors.toList()));
		System.out.println("flux2 = " + flux2.toStream().collect(Collectors.toList()));
		Flux<User> flux3=  Flux.merge(flux1,flux2);
		System.out.println("flux3 = " + flux3.toStream().collect(Collectors.toList()));
		return flux3;
	}

//========================================================================================

	// TODO Merge flux1 and flux2 values with no interleave (flux1 values and then flux2 values)
	Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {

		System.out.println("flux1 = " + flux1.toStream().collect(Collectors.toList()));
		System.out.println("flux2 = " + flux2.toStream().collect(Collectors.toList()));
		Flux<User> flux3=  Flux.concat(flux1,flux2);
		System.out.println("flux3 = " + flux3.toStream().collect(Collectors.toList()));
		return flux3;
	}

//========================================================================================

	// TODO Create a Flux containing the value of mono1 then the value of mono2
	Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {
		return Flux.concat(mono1,mono2);
	}

}
