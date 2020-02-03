public class FileException extends Exception{
	private String Mess = "";
	public FileException (String M)	{
		this.Mess=M;
	}
	public String getMess(){
		return Mess;
	}
}
