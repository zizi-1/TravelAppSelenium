package persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Budget {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int allowance;
	private int remaining;
	private int spent;
	
	
	public Budget() {
		super();
	}


	public Budget(int allowance, int remaining, int spent) {
		super();
		this.allowance = allowance;
		this.remaining = remaining;
		this.spent = spent;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getAllowance() {
		return allowance;
	}


	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}


	public int getRemaining() {
		return remaining;
	}


	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}


	public int getSpent() {
		return spent;
	}


	public void setSpent(int spent) {
		this.spent = spent;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + allowance;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + remaining;
		result = prime * result + spent;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Budget other = (Budget) obj;
		if (allowance != other.allowance)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (remaining != other.remaining)
			return false;
		if (spent != other.spent)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Budget [id=" + id + ", allowance=" + allowance + ", remaining=" + remaining + ", spent=" + spent + "]";
	}
	
	

}
