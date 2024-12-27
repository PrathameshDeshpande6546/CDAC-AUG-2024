package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class EditCandidateBean {
	private int candId;
	private Candidate cand;
	public EditCandidateBean() {
		
	}
	
	public Candidate getCand() {
		return cand;
	}

	public void setCand(Candidate cand) {
		this.cand = cand;
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public void findCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			this.cand = candDao.findById(candId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
