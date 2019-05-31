
package ma.hrpath.stage2019.erecrute.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import ma.hrpath.stage2019.erecrute.model.Profil;

@Component
public class Processor implements ItemProcessor<Profil,Profil> {

	@Override
	public Profil process(Profil item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
