package PR9;

public class NoFIO extends Exception
{
    public NoFIO(INN client)
    {
        super("ФИО клиента "+client.getName()+" не найдено.");
    }
}
