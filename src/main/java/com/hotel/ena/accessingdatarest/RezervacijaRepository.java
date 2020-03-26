package com.hotel.ena.accessingdatarest;


        import java.math.BigDecimal;
        import java.util.List;

        import org.springframework.data.repository.PagingAndSortingRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "rezervacija", path = "rezervacija")
public interface RezervacijaRepository extends PagingAndSortingRepository<Rezervacija, Long> {

    List<Rezervacija> findRezervacija(@Param("user_id") Long user_id);

}