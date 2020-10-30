package PR9;

public class NoINN extends Exception
{
    public NoINN(INN client)
    {
        super("ИНН клиента " +client.getName()+ " не найден.");
    }
}