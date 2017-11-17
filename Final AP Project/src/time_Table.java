import java.io.IOException;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class time_Table implements Serializable {

	private List<Course> courses;
	ArrayList<ArrayList<Boolean>> student_Time_Table = new ArrayList<ArrayList<Boolean>>(5);
	User current_User;

	public time_Table(User current_User) {
		this.current_User = current_User;
	}

	void deserialise() {

	}

	void core_Courses() throws ClassNotFoundException, IOException {
		ArrayList<String> h = new ArrayList<String>();
		h.add("8:00");
		h.add("8:30");
		h.add("9:00");
		h.add("9:30");
		h.add("10:00");
		h.add("10:30");
		h.add("11:00");
		h.add("11:30");
		h.add("12:00");
		h.add("12:30");
		h.add("1:00");
		h.add("1:30");
		h.add("2:00");
		h.add("2:30");
		h.add("3:00");
		h.add("3:30");
		h.add("4:00");
		h.add("4:30");
		h.add("5:00");
		h.add("5:30");

		for (int i = 0; i < 5; i++) {
			this.student_Time_Table.add(i, new ArrayList<Boolean>());
		}

		for (int i = 0; i < this.student_Time_Table.size(); i++) {
			for (int j = 0; j < 20; j++) {
				this.student_Time_Table.get(i).add(false);
			}
		}

		App.deserialize("corecourselist");

		for (int i = 0; i < App.core_Course_List.size(); i++) {
			if (!(App.core_Course_List.get(i).getMon().equals("-"))) {
				String str = App.core_Course_List.get(i).getMon();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(0).set(j, true);
				}
			}

			if (!(App.core_Course_List.get(i).getTue().equals("-"))) {
				String str = App.core_Course_List.get(i).getTue();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(1).set(j, true);
				}
			}

			if (!(App.core_Course_List.get(i).getWed().equals("-"))) {
				String str = App.core_Course_List.get(i).getWed();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(2).set(j, true);
				}
			}

			if (!(App.core_Course_List.get(i).getThurs().equals("-"))) {
				String str = App.core_Course_List.get(i).getThurs();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(3).set(j, true);
				}
			}

			if (!(App.core_Course_List.get(i).getFri().equals("-"))) {
				String str = App.core_Course_List.get(i).getFri();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(4).set(j, true);
				}
			}

		}

		try {
			App.deserialize(current_User.getEmail_id() + "new");
		} catch (NullPointerException e) {
			System.out.println("New File");
		}

		for (int i = 0; i < current_User.newcourse_List.size(); i++) {
			if (!(current_User.newcourse_List.get(i).getMon().equals("-"))) {
				String str = current_User.newcourse_List.get(i).getMon();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(0).set(j, true);
				}
			}

			if (!(current_User.newcourse_List.get(i).getTue().equals("-"))) {
				String str = current_User.newcourse_List.get(i).getTue();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(1).set(j, true);
				}
			}

			if (!(current_User.newcourse_List.get(i).getWed().equals("-"))) {
				String str = current_User.newcourse_List.get(i).getWed();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(2).set(j, true);
				}
			}

			if (!(current_User.newcourse_List.get(i).getThurs().equals("-"))) {
				String str = current_User.newcourse_List.get(i).getThurs();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(3).set(j, true);
				}
			}

			if (!(current_User.newcourse_List.get(i).getFri().equals("-"))) {
				String str = current_User.newcourse_List.get(i).getFri();
				String[] timevenue = str.split(";");
				String duration = timevenue[0];
				String room = timevenue[1];
				String[] time = duration.split("-");
				String starttime = time[0];
				String endtime = time[1];
				String[] start = starttime.split(":");
				String[] end = endtime.split(":");

				if (Integer.parseInt(start[0]) != 8 && Integer.parseInt(start[0]) != 9
						&& Integer.parseInt(start[0]) != 10 && Integer.parseInt(start[0]) != 11) {
					starttime = starttime + " PM";
				} else {
					starttime = starttime + " AM";
				}

				if (Integer.parseInt(end[0]) != 8 && Integer.parseInt(end[0]) != 9 && Integer.parseInt(end[0]) != 10
						&& Integer.parseInt(end[0]) != 11) {
					endtime = endtime + " PM";
				} else {
					endtime = endtime + " AM";
				}

				DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
				LocalTime time1 = LocalTime.parse(starttime, format);
				LocalTime time2 = LocalTime.parse(endtime, format);
				Duration duration1 = Duration.between(time1, time2);
				int slots = (int) Math.abs(duration1.getSeconds() / 60);

				int s = h.indexOf(time[0]);
				int limit = s + (slots / 30);

				for (int j = s; j < limit; j++) {
					this.student_Time_Table.get(4).set(j, true);
				}
			}

		}

		try {
			if (current_User.newcourse_List.size() > 0) {
				App.serialize(current_User.getEmail_id() + "new", "register");
				System.out.println("A");
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		App.serialize("courselist", "course");
	}

	boolean add(Course add_Course) {
		return false;
	}

	boolean delete(Course delete_Course) {
		return false;
	}

	void show() {

	}

	// public static void main(String[] args) throws ClassNotFoundException,
	// IOException
	// {
	// time_Table obj = new time_Table();
	// obj.core_Courses();
	// }
}