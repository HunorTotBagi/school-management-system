package com.electric_diary.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.electric_diary.entities.ParentEntity;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ParentRepositoryTests {
    @Mock
    private ParentRepository parentRepository;

    @Test
    public void ParentRepository_SaveAll_ReturnSavedParent() {
        // Arrange
    	ParentEntity parent = ParentEntity.builder()
                .firstName("Ana")
                .lastName("Nikolic")
                .email("ana.nikolic@gmail.com")
                .build();

    	ParentEntity savedParent = ParentEntity.builder()
                .id(1)
                .firstName("Ana")
                .lastName("Nikolic")
                .email("ana.nikolic@gmail.com")
                .build();
        
        Mockito.when(parentRepository.save(parent)).thenReturn(savedParent);

        // Act
        ParentEntity result = parentRepository.save(parent);

        // Assert
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isGreaterThan(0);
    }
    
	@Test
	public void ParentRepository_FindAll_ReturnMoreThanOneParent() {
	    // Arrange
    	ParentEntity firstParent = ParentEntity.builder()
                .firstName("Ana")
                .lastName("Nikolic")
                .email("ana.nikolic@gmail.com")
                .build();
	    
    	ParentEntity secondParent = ParentEntity.builder()
                .firstName("Bogdan")
                .lastName("Ivanović")
                .email("bogdan.ivanovic@gmail.com")
                .build();
	    
	    List<ParentEntity> parentList = Arrays.asList(firstParent, secondParent);

	    Mockito.when(parentRepository.findAll()).thenReturn(parentList);
	    
	    // Act
	    Iterable<ParentEntity> result = parentRepository.findAll();
	    
	    // Assert
	    Assertions.assertThat(result).isNotNull();
	    Assertions.assertThat(result).hasSize(2);
	    Assertions.assertThat(result).containsExactlyInAnyOrder(firstParent, secondParent);
	}
	
	@Test
	public void ParentRepository_FindById_ReturnParent() {
	    // Arrange
    	ParentEntity parent = ParentEntity.builder()
                .firstName("Bogdan")
                .lastName("Ivanović")
                .email("bogdan.ivanovic@gmail.com")
                .build();
	    
	    Mockito.when(parentRepository.findById(parent.getId())).thenReturn(Optional.of(parent));
	    
	    // Act
	    Optional<ParentEntity> result = parentRepository.findById(parent.getId());
	    
	    // Assert
	    Assertions.assertThat(result).isPresent();
	    Assertions.assertThat(result.get()).isEqualTo(parent);
	}
}
