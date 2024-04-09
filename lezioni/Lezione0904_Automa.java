package lezioni; 

public class Lezione0904_Automa
{
    private int stato; 

    public Automa()
    {
        stato = 0; 
    }

    public boolean riconosci( String s )
    {


    }

    private void transizione( char c ) // lo carica lui 
    {
        switch (stato)
        {
            case 0:
                if ( c == 'a' )
                    stato = 1; 
                else
                    stato = 2; 
                break;
            case 1:
                if ( c == 'b' )
                    stato = 3; 
                else
                    stato = 2; 
                break;
            case 2:
                break;
            case 3:
                 

        }

    }
}