import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("teams/:id/members/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Member member = Member.find(Integer.parseInt(request.params(":id")));
        model.put("member", member);
        model.put("template", "templates/team-members-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/members", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("members", Member.all());
     model.put("template", "templates/members.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      String language = request.queryParams("language");
      String skill = request.queryParams("skill");
      Member newMember = new Member(name, language, skill);
      team.addMember(newMember);
      model.put("team", team);
      model.put("template", "templates/team-member-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/members/:id", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     Member member = Member.find(Integer.parseInt(request.params(":id")));
     model.put("member", member);
     model.put("template", "templates/member.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String newName = request.queryParams("newName");
      Team newTeam = new Team(newName);
      model.put("template", "templates/team-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     model.put("teams", Team.all());
     model.put("template", "templates/teams.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    get("/teams/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
