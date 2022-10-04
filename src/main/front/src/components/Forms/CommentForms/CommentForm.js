import React, { useState } from "react";
import axios from "axios";
import styles from "../../../styles/ContentModal.module.css";

const CommentForm = ({context}) => {
    const [commentValue, setCommentValue] = useState("");
    const [lists, setLists] = useState([])

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
                    .then((res) => {
                        console.log(res.data)
                        setLists(res.data)
                    })
                })

        }
        catch (e) { console.log(e) };
    };

    const CommentList = () =>{
        return(
            <>
                {lists.map((list) =>{
                    <div>
                        <div>{list.email}</div>
                        <div>{list.comment}</div>
                        <div>{list.createdAt}</div>
                    </div>
                })}
            </>
        )
    }
    return (
        <div>
            <CommentList />
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
        </div>
    );
};

export default CommentForm;