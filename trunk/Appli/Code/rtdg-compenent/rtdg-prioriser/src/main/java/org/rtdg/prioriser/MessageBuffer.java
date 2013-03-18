package org.rtdg.prioriser;


import java.util.LinkedList;

import org.rtdg.parser.ParsedMessage;



public class MessageBuffer  extends LinkedList<ParsedMessage>{
	
	private String name;
	
	public MessageBuffer(String name){
		this.name=name;
	}
	public void addBefore(ParsedMessage obj){
		if(!this.contains(obj))
		this.addFirst(obj);
		
	}
	
	public void addAfter(ParsedMessage obj){
		if(!contains(obj))
			addLast(obj);		
	}
	
	public void addMessage(ParsedMessage obj){
		if(!contains(obj))
			this.add(obj);
		
	}
	 public void addAt(ParsedMessage obj,int index){
			if(!contains(obj))
				this.add(index,obj);
	 }
	 
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void removeBefore(){
		 if(!this.isEmpty())
			 removeFirst();
	 }
	 public void removeAfter(){
		 if(!this.isEmpty())
			 removeLast();
	 }
	 public void removeMessage(ParsedMessage obj){
		 if(!this.isEmpty())
			 remove(obj);
	 }
	 public void removeAt(int index){
		 if(!this.isEmpty())
			 remove(index);
	 }


}
