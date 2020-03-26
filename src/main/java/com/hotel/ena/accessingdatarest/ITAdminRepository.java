package com.hotel.ena.accessingdatarest;


        import java.math.BigDecimal;
        import java.util.List;

        import org.springframework.data.repository.PagingAndSortingRepository;
        import org.springframework.data.repository.query.Param;
        import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "itadmin", path = "itadmin")
public interface ITAdminRepository extends PagingAndSortingRepository<ITAdmin, Long> {

    //List<ITAdmin> findITAdmin(@Param("user_id") Long user_id);
//ako ovo bude imalo smisla
}