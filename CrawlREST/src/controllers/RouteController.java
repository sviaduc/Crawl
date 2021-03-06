package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.RouteDAO;
import entities.Route;
import entities.RouteVenue;
import entities.Venue;

@RestController
public class RouteController {
	@Autowired
	private RouteDAO routeDao;
	
	@RequestMapping(path="routes/ping", method=RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	//Gets all routes
	@RequestMapping(path="users/{uid}/routes", method=RequestMethod.GET)
	public List<Route> indexRoutes(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid) {
		res.setStatus(202);
		return routeDao.index(uid);
	}

	@RequestMapping(path="users/{uid}/venuesExcept/{rid}", method=RequestMethod.GET)
	public List<Venue> index(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid,@PathVariable int rid) {
		res.setStatus(202);
		return routeDao.showAllVenuesExcept(uid, rid);
	}


	@RequestMapping(path="users/{uid}/routes/{sid}", method=RequestMethod.GET)
	public Route show(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid,@PathVariable int sid) {
		res.setStatus(202);
		return routeDao.showRoute(uid, sid);
	}
	
	@RequestMapping(path="users/{uid}/routes/{sid}/routeVenues", method=RequestMethod.GET)
	public List<RouteVenue> showRouteVenuesByRoute(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid,@PathVariable int sid) {
		res.setStatus(202);
		return routeDao.showRouteVenuesByRoute(uid, sid);
	}

	@RequestMapping(path="users/{uid}/routes/{sid}/venues", method=RequestMethod.GET)
	public List<Venue> showVenuesByRoute(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid,@PathVariable int sid) {
		res.setStatus(202);
		return routeDao.showVenuesByRoute(uid, sid);
	}
	
	@RequestMapping(path="users/{uid}/routes", method=RequestMethod.POST)
	public Route create(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @RequestBody String routeJson) {
		res.setStatus(201);
		
		return routeDao.createRoute(uid,routeJson);
	}
	

	@RequestMapping(path="users/{uid}/routes/{rid}/venues/{vid}/change/{change}", method=RequestMethod.PUT)
	public Boolean editVenueOrder(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid,@PathVariable int rid, @PathVariable int vid, @PathVariable int change) {
		res.setStatus(202);
		return routeDao.editVenueOrder(uid, rid, vid, change);
	}


	@RequestMapping(path="users/{uid}/routes/{sid}", method=RequestMethod.PUT)
	public Route updateRoute(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int sid, @RequestBody String routeJson) {
		res.setStatus(202);
		return routeDao.updateRoute(uid, sid, routeJson);
	}


	
	@RequestMapping(path="users/{uid}/routes/{sid}", method=RequestMethod.DELETE)
	public Boolean destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int sid) {
		res.setStatus(202);
		return routeDao.deleteRoute(uid, sid);
	}
	
	@RequestMapping(path="users/{uid}/routes/{rid}/addVenues/{vid}", method=RequestMethod.PUT)
	public Route addVenueToRoute(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int rid, @PathVariable int vid) {
		res.setStatus(202);
		return routeDao.addVenueToRoute(uid, rid, vid);
	}

	@RequestMapping(path="users/{uid}/routes/{rid}/removeVenues/{vid}", method=RequestMethod.PUT)
	public Route removeVenueFromRoute(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid, @PathVariable int rid, @PathVariable int vid) {
		res.setStatus(202);
		return routeDao.removeVenueFromRoute(uid, rid, vid);
	}
	
}
