package com.ddww.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BoardDTO {
	private int bno, blike, commentcount, rowNum;
	private String btitle, bcontent, m_name, m_id, bdate, bip, uuid;
}
