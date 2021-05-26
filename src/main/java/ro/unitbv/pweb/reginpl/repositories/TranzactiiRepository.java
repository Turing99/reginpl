package ro.unitbv.pweb.reginpl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ro.unitbv.pweb.reginpl.models.TranzactieModel;

@Repository
public interface TranzactiiRepository extends JpaRepository<TranzactieModel, Long> {
	
	@Query(value = "SELECT * FROM tranzactii ORDER BY tstamp DESC", nativeQuery = true)
	public List<TranzactieModel> getAllSorted();

	public List<TranzactieModel> findAllByOrderByTstampDesc();
}
