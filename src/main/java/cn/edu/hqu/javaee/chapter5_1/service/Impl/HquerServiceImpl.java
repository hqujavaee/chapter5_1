package cn.edu.hqu.javaee.chapter5_1.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hqu.javaee.chapter5_1.entity.Hquer;
import cn.edu.hqu.javaee.chapter5_1.repository.HquerRepository;
import cn.edu.hqu.javaee.chapter5_1.service.HquerService;

@Service
@Transactional
public class HquerServiceImpl implements HquerService{
	@Autowired
	HquerRepository hquerRepository;

	@Override
	public Hquer login(String userName, String password) {
		Hquer hquer;
		if((hquer=hquerRepository.findByUserName(userName))!=null 
				&& hquer.getPassword().equals(password)) {
			System.out.println(hquer.getUserName());
			return hquer;
		}
		return null;
	}

	@Override
	public boolean register(Hquer hquer) {
		if((hquerRepository.findByUserName(hquer.getUserName()))==null) {
			hquerRepository.save(hquer);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Hquer getUserDetail(String userName) {
		return hquerRepository.findByUserName(userName);
	}

}
