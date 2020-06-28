package market.priceFeed.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import market.priceFeed.entity.Feed;

@Repository  
public interface FeedRepository extends JpaRepository<Feed, Long> {  

	@Query("SELECT f FROM Feed f WHERE upper(f.name) = upper(:name)")
	Optional<Feed> findByName(@Param("name") String name);
	
}