package main.scs.dto;

public class AssetDTO
{

	private int id;
	private String name;
	private String holderName;
	private String sku;
	private String description;
	private byte[] image;
	private String base64Image;
	private String imageString;
	private byte[] imageData;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getHolderName()
	{
		return holderName;
	}

	public void setHolderName(String holderName)
	{
		this.holderName = holderName;
	}

	public String getSku()
	{
		return sku;
	}

	public void setSku(String sku)
	{
		this.sku = sku;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public byte[] getImage()
	{
		return this.image;
	}

	public String getBase64Image()
	{
		return base64Image;
	}

	public void setBase64Image(String base64Image)
	{
		this.base64Image = base64Image;
	}

	public String getImageString()
	{
		return imageString;
	}

	public void setImageString(String imageString)
	{
		this.imageString = imageString;
	}

	public byte[] getImageData()
	{
		return imageData;
	}

	public void setImageData(byte[] imageData)
	{
		this.imageData = imageData;
	}

}
