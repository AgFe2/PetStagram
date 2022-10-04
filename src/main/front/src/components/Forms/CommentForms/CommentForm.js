import React, { useState } from "react";
import axios from "axios";
import styles from "../../../styles/ContentModal.module.css";

const CommentForm = ({context}) => {
    const [commentValue, setCommentValue] = useState("");
    

    const onChangeComment = (e) => {
        console.log(typeof e.target.value);
        setCommentValue(e.target.value);
    };

    const addComment = async (e) => {
        e.preventDefault();
        let feed_Id = 1
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
                            feedId: feed_Id,
                        },
                    }
                )
                .then((res) => {
                    setCommentValue("");
                    console.log(res);
                    axios.get(`http://localhost:8080/feed/show-comments?feedId=${feed_Id}`)
                    .then((response) => {
                        console.log(response.data)
                        context = response.data
                    })
                })

        }
        catch (e) { console.log(e) };
    };

    console.log(context)
    return (
        <>  
            <form className={styles.inputForm} onSubmit={addComment}>
                <input
                    type="text"
                    placeholder="댓글 달기..."
                    className={styles.inputComment}
                    value={context}
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