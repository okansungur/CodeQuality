package com.example.students.dto;


public class LectureRequest {
	private Long requestId;
	private Long studentId;
	private Long lectureId;
	private String semester;

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getLectureId() {
		return lectureId;
	}

	public void setLectureId(Long lectureId) {
		this.lectureId = lectureId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public LectureRequest(Long requestId, Long studentId, Long lectureId, String semester) {
		this.requestId = requestId;
		this.studentId = studentId;
		this.lectureId = lectureId;
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "LectureRequest{" +
				"requestId=" + requestId +
				", studentId=" + studentId +
				", lectureId='" + lectureId + '\'' +
				", semester='" + semester + '\'' +
				'}';
	}
}
