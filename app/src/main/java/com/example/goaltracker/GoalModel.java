package com.example.goaltracker;

public class GoalModel {
    String GoalName;
    String ProgressPercentage;
    String Importance;
    int Year;
    int Month;
    int Day;
    int imagecolor;
    String Category;
    String Description;
    String Duedate;


    public GoalModel(String goalName, String progressPercentage, String importance, int year, int month, int day, String category, String description)
    {
        GoalName = goalName;
        ProgressPercentage = progressPercentage;
        Importance = importance;
        Year = year;
        Month = month;
        Day = day;
        Category = category;
        Description = description;
    }
    public int getimagecolor(String Importance){
        if (Importance=="Very Important"){
            return(R.drawable.importance0);
        }
        else if (Importance=="Important"){
            return(R.drawable.important1);
        }
        else return R.drawable.impotance2;
    }

    public String getDuedate(){
        return (Month+","+Day+","+Year);
    }
    public String getGoalName() {
        return GoalName;
    }

    public String getProgressPercentage() {
        return ProgressPercentage;
    }

    public String getImportance() {
        return Importance;
    }

    public int getYear() {
        return Year;
    }

    public int getMonth() {
        return Month;
    }

    public int getDay() {
        return Day;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }
}
