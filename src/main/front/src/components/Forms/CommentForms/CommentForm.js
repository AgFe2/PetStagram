import React, { useState } from "react";
import axios from "axios";
import styles from "../../../styles/ContentModal.module.css";

const CommentForm = ({comment}) => {
    const [commentValue, setCommentValue] = useState("");

    const onChangeComment = (e) => {
        console.log(typeof e.target.value);
        setCommentValue(e.target.value);
    };

    const addComment = async (e) => {
        e.preventDefault();

        try {
            await axios
                .post(
                    "http://localhost:8080/feed/save-comment",
                    JSON.stringify({
                        context:commentValue,
                    }),
                    {
                        headers: {
                            "Content-Type": "application/json",
                            Authorization: "Bearer" + localStorage.getItem("JWT"),
                        },
                        params: {
                            feedId: 1,
                        },
                    }
                )
                .then((res) => {
                    axios.get(`http://localhost:8080/feed/show-comments?${feedId}`)
                    setCommentValue("");
                    console.log(res);
                })

        }
        catch (e) { console.log(e) };
    };

    console.log(commentValue)
    return (
        <>
            <form className={styles.inputForm} onSubmit={addComment}>
                <input
                    type="text"
                    placeholder="댓글 달기..."
                    className={styles.inputComment}
                    value={commentValue}
                    onChange={onChangeComment}
                />
                {commentValue.length > 0 ? (
                    <button
                        type="submit"
                        className={`${styles.inputButton} ${styles.btnActive}`}
                    >
                        게시
                    </button>
                ) : (
                    <button type="button" className={styles.inputButton}>
                        게시
                    </button>
                )}
            </form>
        </>
    );
};

export default CommentForm;