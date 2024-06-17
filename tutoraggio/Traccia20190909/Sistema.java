package traccia20190909;

import java.util.*;

public class Sistema {
	private ArrayList<Parlamentare> parlamentari;
	private ArrayList<DisegnoDiLegge> ddl;
	private ArrayList<Votazione> votazioni;
	
	public Sistema(ArrayList<Parlamentare> parlamentari,ArrayList<DisegnoDiLegge> ddl, ArrayList<Votazione> votazioni)
	{	this.parlamentari=parlamentari;
		this.ddl=ddl;
		this.votazioni=votazioni;
	}
	
	public ArrayList<DisegnoDiLegge> m1(String r)
	{	ArrayList<DisegnoDiLegge> ret=new ArrayList<>();
		for(int i=0;i<ddl.size();i++)
		{	DisegnoDiLegge ddl1=ddl.get(i);
			if(ddl1.getEsito()==false)
				continue;
			boolean ok=true;
			for(int j=0;j<votazioni.size();j++)
			{	if(votazioni.get(j).getVoto()==true && votazioni.get(j).getDisegnoDiLegge() == ddl1.getId())
				{	String cf=votazioni.get(j).getParlamentare();
					for(int k=0;k<parlamentari.size();k++)
					{	if(parlamentari.get(k).getCf().equals(cf) && parlamentari.get(j).getRegione().equals(r))
						{	break;
						}
						else if(parlamentari.get(k).getCf().equals(cf) && !parlamentari.get(k).getRegione().equals(r))
							ok=false;
					}
					if(ok==false)
						break;
				}
			}
			if(ok==true)
				ret.add(ddl1);
		}
		return ret;
	}
	
	
	public ArrayList<Parlamentare> m2(String p)
	{	ArrayList<Parlamentare> ret=new ArrayList<>();
		for(int i=0;i<parlamentari.size();i++)
		{	Parlamentare att=parlamentari.get(i);
			if(!att.getPartito().equals(p))
				continue;
			for(int j=0;j<votazioni.size();j++)
			{	if(votazioni.get(j).getParlamentare().equals(att.getCf()) && votazioni.get(j).getVoto()==false)
				{	int x=votazioni.get(j).getDisegnoDiLegge();
					for(int k=0;k<ddl.size();k++)
					{	if(ddl.get(k).getId()==x)
						{	ArrayList<String> parl=ddl.get(k).getParlamentari();
							for(int q=0;q<parl.size();q++)
							{	for(int n=0;n<parlamentari.size();n++)
								{	if(parlamentari.get(n).getCf().equals(parl.get(q)) && parlamentari.get(n).getPartito().equals(p))
									{	if(! ret.contains(att))
										{	ret.add(att);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return ret;
	}
	
	
	public ArrayList<DisegnoDiLegge> m3(DisegnoDiLegge d)
	{	ArrayList<DisegnoDiLegge> ret=new ArrayList<>();
		ArrayList<String> l=d.getParlamentari();
		for(int i=0;i<l.size();i++)
		{	for(int j=0;j<ddl.size();j++)
			{	if(ddl.get(j).getEsito()==true && !ddl.get(j).equals(d))
				{	ArrayList<String> verifica=ddl.get(j).getParlamentari();
					if(verifica.contains(l.get(i)) && !ret.contains(ddl.get(j)))
						ret.add(ddl.get(j));
				}
			}
		}
		Collection.sort(ret);
		return ret;
	}

	
}
