package ro.unitbv.pweb.reginpl.api;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.unitbv.pweb.reginpl.models.TranzactieModel;
import ro.unitbv.pweb.reginpl.repositories.TranzactiiRepository;
@CrossOrigin
@RestController
@RequestMapping("api/tranzactii")
public class TranzactiiController {

	@Autowired
	private	TranzactiiRepository tranzactiiRepository;
	
	@GetMapping("/hello/{name}")
	public String sayHello(@PathVariable("name") String name)
	{
		return "Hello" + name;
	}
	@GetMapping(value="/now",produces = { MediaType.APPLICATION_JSON_VALUE })
	public Map<String, Integer> now()
	{
		Map<String,Integer> res = new HashMap<String,Integer>();
		
		LocalDateTime crtTime = LocalDateTime.now();
		
		res.put("ora", crtTime.getHour());
		res.put("minut", crtTime.getMinute());
		res.put("secunda", crtTime.getSecond());
		
		return res;
	}
	
	@GetMapping(value="/tranzactii",produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<TranzactieModel> retrieveAllTransactions()
	{
		return tranzactiiRepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping(value="/save", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.TEXT_PLAIN_VALUE})
	public String saveTransaction(@RequestBody TranzactieModel tranzactie)
	{
		TranzactieModel saved = tranzactiiRepository.save(tranzactie);
		
		return "OK:" + saved.getId();
	}
	
	@PostMapping(value="/update", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.TEXT_PLAIN_VALUE})
	public String updateTransaction(@RequestBody TranzactieModel tranzactie)
	{
		tranzactiiRepository.save(tranzactie);
		
		return "OK";
	}
	
	@DeleteMapping(value="/delete/{id}", consumes = { MediaType.ALL_VALUE }, produces = {MediaType.TEXT_PLAIN_VALUE})
	public String deleteTransaction(@PathVariable("id") long id)
	{
		tranzactiiRepository.deleteById(id);
		
		return "OK";
	}
	
	@CrossOrigin
	@GetMapping(value="/sorted",produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<TranzactieModel> retrieveAllTransactionsSorted()
	{
		return tranzactiiRepository.findAllByOrderByTstampDesc();
	}
}
