package ro.unitbv.pweb.reginpl.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tranzactii")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TranzactieModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	private	Long id;
	@Column(name="tip_tranzactie")
	@JsonProperty("tipTranzactie")
	private	String tipTranzactie;
	private	Double valoare;
	private	String descriere;
	private	LocalDateTime tstamp;

}
