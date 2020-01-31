public class FileException extends Exception{
	private String mess = "";
	public FileException (String M)	{
		this.mess=M;
	}
	public String getMess(){
		return mess;
	}
}
