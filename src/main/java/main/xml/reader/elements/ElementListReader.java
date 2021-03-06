//
// Armands  02.07.2015.
// HanabiSim
//


package main.xml.reader.elements;


import main.xml.XMLUtils;
import main.xml.reader.XMLData;
import main.xml.reader.templates.XMLElementTemplate;


public class ElementListReader extends EmptyReader
{
	public ElementListReader(EmptyReader reader, XMLData dataSaver, XMLElementTemplate parentTemplate)
	{
		super(reader);
		this.dataSaver = dataSaver;
		this.parentTemplate = parentTemplate;
	}


	public EmptyReader newTag(String tag)
	{
		EmptyReader reader;

		if (tag.equals(XMLUtils.ELEMENT))
		{
			XMLElementTemplate elementTemplate = new XMLElementTemplate();
			elementTemplate.setElementTemplate(this.parentTemplate);
			reader = new ElementReader(this, this.dataSaver, elementTemplate);
			this.dataSaver.addElementTemplate(elementTemplate);
		}
		else
		{
			reader = new EmptyReader(this);
		}

		return reader;
	}


	// ---------------------------------------------------------------------
	// Section: Variables
	// ---------------------------------------------------------------------


	private XMLData dataSaver;

	private XMLElementTemplate parentTemplate;
}
