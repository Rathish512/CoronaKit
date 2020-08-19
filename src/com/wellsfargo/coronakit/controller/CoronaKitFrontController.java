package com.wellsfargo.coronakit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.coronakit.entity.CoronaKit;
import com.wellsfargo.coronakit.exception.CoronaException;
import com.wellsfargo.coronakit.service.CoronaKitService;
import com.wellsfargo.coronakit.service.CoronaKitServiceImpl;

@WebServlet({ "/list", "/deleteItem", "/newItem", "/addItem", "/editItem", "/saveItem" })
public class CoronaKitFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CoronaKitService coronaKitService;
       
    @Override
	public void init() throws ServletException {
    	coronaKitService = new CoronaKitServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		String view ="";
		switch(url)
		{
		case "/list":
			view = doListCoronaKit(request,response);
			break;
		
		case "/deleteItem":
			view = doDeleteItem(request,response);
			break;
			
		case "/newItem":
			view = doAddItem(request,response);
			break;
			
		case "/addItem":
			view = doCreateOrSaveItem(request,response);
			break;
			
		case "/editItem":
			view = doEditItem(request,response);
			break;
			
		case "/saveItem":
			view = doCreateOrSaveItem(request,response);
			break;
		}
		
		request.getRequestDispatcher(view).forward(request, response);
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String doListCoronaKit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String view="";
		try
		{
			List<CoronaKit> coronaKits=coronaKitService.getAllCoronaKits();
			request.setAttribute("coronaKits", coronaKits);
			view = "listItems.jsp";
		}
		catch(CoronaException e)
		{
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		
		return view;
	}
	
	private String doDeleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String view="";
		int coronaKitId = Integer.parseInt(request.getParameter("id"));
		try
		{
			coronaKitService.deleteCoronaKit(coronaKitId);
			request.setAttribute("Msg", "Item Deleted!");
			view="index.jsp";
		}
		catch(CoronaException e)
		{
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		return view;
	}
	
	private String doAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String view="";
		CoronaKit coronaKit = new CoronaKit();
		request.setAttribute("coronaKit", coronaKit);
		request.setAttribute("isNew", true);
		view="newitem.jsp";
		return view;
	}
	
	private String doCreateOrSaveItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CoronaKit coronaKit = new CoronaKit();
		coronaKit.setId(Integer.parseInt(request.getParameter("id")));
		coronaKit.setName(request.getParameter("name"));
		coronaKit.setDescription(request.getParameter("description"));
		coronaKit.setCost(Double.parseDouble(request.getParameter("cost")));
		String view="";
		try
		{
			if(request.getServletPath().equals("/addItem"))
			{
				coronaKitService.validateAndAdd(coronaKit);
			}
			else
			{
				coronaKitService.validateAndEdit(coronaKit);
			}
			
			request.setAttribute("msg", "Item is saved");
			view="index.jsp";
		}
		catch(CoronaException e)
		{
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		
		
		return view;
	}
	
	private String doEditItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String view ="";
		int coronaKitId = Integer.parseInt(request.getParameter("id"));
		try
		{
			CoronaKit coronaKit = coronaKitService.getItem(coronaKitId);
			request.setAttribute("coronaKit", coronaKit);
			request.setAttribute("isNew", false);
			view="newitem.jsp";
		}
		catch(CoronaException e)
		{
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		return view;
	}

}
