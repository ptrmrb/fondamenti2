import java.util.*;

public class GestioneParentele 
{	private ArrayList<String> parentele;
	
	public GestioneParentele()
	{	parentele = new ArrayList<>();
		parentele.add("Luigi A.");
		parentele.add("Francesco A.");
		parentele.add("Maria B.");
		parentele.add("Luigi A.");
		parentele.add("Giovanna C.");
		parentele.add("Paolo B.");
		parentele.add("Francesca D.");
		parentele.add("Francesco A.");
		parentele.add("Paola E.");
		parentele.add("Mario C.");
		parentele.add("Anna F.");
		parentele.add("Antonio B.");
		parentele.add("Simona G.");
		parentele.add("Giovanni D.");
		parentele.add("Maria H.");
	}
	
	public String nome(int i)
	{	return parentele.get(i);
	}
	
	public int indicePadre(int i)
	{	return 2 * i + 1;		
	}
	
	public int indiceMadre(int i)
	{	return 2 * i + 2;		
	}
	
	public boolean genitoriMemorizzati(int i)
	{	return indiceMadre(i) < parentele.size();
	}
	
	public boolean eAscendente(int i1, int i2)
	{	if(!genitoriMemorizzati(i2))
			return false;
		int padreI2 = indicePadre(i2);
		int madreI2 = indiceMadre(i2);
		return i1 == padreI2 || i1 == madreI2 || eAscendente(i1,padreI2) || eAscendente(i1,padreI2);
	}
	
	public ArrayList<Integer> ascendenti(int i)
	{	ArrayList<Integer> ret = new ArrayList<>();
		if(!genitoriMemorizzati(i))
			return ret;
		int padre = indicePadre(i);
		int madre = indiceMadre(i);
		ret.add(padre);
		ret.add(madre);
		ret.addAll(ascendenti(padre));
		ret.addAll(ascendenti(madre));
		return ret;
	}
	
	public int contaAscendenti(int i)
	{	if(!genitoriMemorizzati(i))
			return 0;
		int padre = indicePadre(i);
		int madre = indiceMadre(i);
		return 2 + contaAscendenti(padre) + contaAscendenti(madre);
	}
}
