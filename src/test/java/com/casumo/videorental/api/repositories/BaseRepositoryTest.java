//package com.casumo.videorental.api.repositories;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.when;
//
//public abstract class BaseRepositoryTest<T extends JpaRepository<E, Long>, E> {
//
//    @Mock
//    protected T repository;
//
//    @Before
//    public void setUp() {
//
//    }
//
//    @Test
//    public void testFindById_whenExists_returnsEntity() {
//        // Configure mock behavior
//        MockitoAnnotations.initMocks(this);
//        Long id = 1L;
//        E expectedEntity = /* Create your entity instance */;
//        when(repository.findById(id)).thenReturn(Optional.of(expectedEntity));
//
//        // Call method under test
//        Optional<E> result = repository.findById(id);
//
//        // Assert results
//        assertTrue(result.isPresent());
//        assertEquals(expectedEntity, result.get());
//        verify(repository).findById(id);
//    }
//
//    @Test
//    public void testFindById_whenNotFound_returnsEmptyOptional() {
//        // Configure mock behavior
//        Long id = 1L;
//        when(repository.findById(id)).thenReturn(Optional.empty());
//
//        // Call method under test
//        Optional<E> result = repository.findById(id);
//
//        // Assert results
//        assertFalse(result.isPresent());
//        verify(repository).findById(id);
//    }
//
//    // Add additional test methods following the same structure
//
//
//    /**
//     * Override this method in concrete repository tests to provide specific entity type.
//     * @return the entity type for the specific repository
//     */
//    protected abstract Class<E> getEntityType();
//}
